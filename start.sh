podman build -t demoapp .
podman run --name demo -p 1111:8080 -m 200m demoapp
