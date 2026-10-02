#!/usr/bin/env bash
set -euo pipefail

PORT="${PORT:?PORT environment variable is required}"

cd "$(dirname "$0")/../project"

mvn spring-boot:run