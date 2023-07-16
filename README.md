# qrgen

[![CI](https://github.com/milgradesec/qrgen/actions/workflows/java-ci.yml/badge.svg)](https://github.com/milgradesec/qrgen/actions/workflows/java-ci.yml)
![GitHub tag (latest by date)](https://img.shields.io/github/v/tag/milgradesec/qrgen)
![GitHub](https://img.shields.io/github/license/milgradesec/nbot)

`qrgen` is a very simple Java QR generator microservice.

## Install `qrgen`

🐳 Get Docker image:

```shell
docker pull ghcr.io/milgradesec/qrgen:latest
```

Example `compose.yaml`

```yaml
services:
  qrgen:
    image: ghcr.io/milgradesec/qrgen:latest
    ports:
      - 8080:8080/tcp
    deploy:
      resources:
        limits:
          cpus: "1"
          memory: 256M
      restart_policy:
        condition: any
```

## License

Apache License 2.0
