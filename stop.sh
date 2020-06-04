podman stop $(podman ps -a -q)
podman rm -vf $(podman ps -a -q)
podman container prune -f
podman ps -a
podman rmi $(podman images |grep 'demoapp')
