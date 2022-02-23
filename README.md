# qrgen

[![CI](https://github.com/milgradesec/qrgen/actions/workflows/java-ci.yml/badge.svg)](https://github.com/milgradesec/qrgen/actions/workflows/java-ci.yml)
[![Docker CI](https://github.com/milgradesec/qrgen/actions/workflows/docker-ci.yml/badge.svg)](https://github.com/milgradesec/qrgen/actions/workflows/docker-ci.yml)
![GitHub tag (latest by date)](https://img.shields.io/github/v/tag/milgradesec/qrgen)
![GitHub](https://img.shields.io/github/license/milgradesec/nbot)

`qrgen` is a Java QR generator microservice.

## Install `qrgen`

🐳 Get Docker image:

```shell
docker pull ghcr.io/milgradesec/qrgen:latest
```

Example `docker-compose.yaml`

```yaml
version: "3.8"

services:
  qrgen:
    image: ghcr.io/milgradesec/qrgen:latest
    read_only: true
    ports:
      - 8080/tcp
    volumes:
      - type: tmpfs
        target: /tmp
    cap_drop:
      - ALL
    deploy:
      resources:
        limits:
          cpus: "1"
          memory: 256M
```

## License

Apache License 2.0
