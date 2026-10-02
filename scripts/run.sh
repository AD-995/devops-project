#!/usr/bin/env bash
set -euo pipefail

cd "$(dirname "$0")/../project"

mvn spring-boot:run