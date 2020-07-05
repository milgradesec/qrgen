.PHONY: release
release:
	gradlew build
	docker.exe buildx build --platform linux/arm64 . -t milgradesec/qrgen:latest --push