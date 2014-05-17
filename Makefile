JAVA_SOURCE = java

TARGETS = $(JAVA_SOURCE)

.PHONY: all $(TARGETS) pull push

all: $(TARGETS)

$(TARGETS):
	@$(MAKE) -C $@

pull:
	git pull

push:
	git push origin master
