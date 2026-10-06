#!/usr/bin/env bash
set -euo pipefail

PORT="${PORT:-8080}"
BASE_URL="http://localhost:${PORT}"

cd "$(dirname "$0")/../project"

PORT="$PORT" mvn spring-boot:run &
APP_PID=$!

# Wait for the application to start
until curl -s "$BASE_URL/" > /dev/null 2>&1; do
    sleep 1
done

passed=0
total=3

BASE_URL="http://localhost:8080"

# Test /
if [ "$(curl -s -o /dev/null -w "%{http_code}" "$BASE_URL/")" = "201" ]; then
    passed=$((passed + 1))
fi

# Test /healthz
if [ "$(curl -s -o /dev/null -w "%{http_code}" "$BASE_URL/healthz")" = "200" ]; then
    passed=$((passed + 1))
fi

# Test /notes
if [ "$(curl -s -o /dev/null -w "%{http_code}" "$BASE_URL/notes")" = "200" ]; then
    passed=$((passed + 1))
fi


echo "TESTS: $passed/$total"

kill "$APP_PID" 2>/dev/null || true

if [ "$passed" -ne "$total" ]; then
    exit 1
fi

exit 0