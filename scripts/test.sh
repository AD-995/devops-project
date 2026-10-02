#!/usr/bin/env bash
set -euo pipefail

passed=0
total=3

BASE_URL="http://localhost:${PORT}"

# Test /
if [ "$(curl -s -o /dev/null -w "%{http_code}" "$BASE_URL/")" = "200" ]; then
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