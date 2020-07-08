.PHONY: release
release:
	gradlew build
	docker.exe buildx build --platform linux/arm/v7 . -t milgradesec/qrgen:latest --push