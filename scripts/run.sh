#!/usr/bin/env bash
set -euo pipefail

PORT="${PORT:-8080}"

cd "$(dirname "$0")/../project"

mvn spring-boot:run