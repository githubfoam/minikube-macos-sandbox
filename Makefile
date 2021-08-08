IMAGE := alpine/fio
APP:="app/deploy-openesb.sh"

deploy-MD5encrypter-app:
	bash app/deploy-MD5encrypter-app.sh

push-image:
	docker push $(IMAGE)
.PHONY: deploy-openesb deploy-dashboard push-image
