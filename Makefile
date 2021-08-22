VERSION := $(shell git describe --tags --always --abbrev=0)

build:
	./gradlew build

docker:
	docker build . -f build.Dockerfile

docker-release:
	docker buildx build . -f build.Dockerfile \
		--platform linux/arm64 \
		--tag ghcr.io/milgradesec/qrgen:$(VERSION) \
		--tag ghcr.io/milgradesec/qrgen:latest \
		--push