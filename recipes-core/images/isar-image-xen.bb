require recipes-core/images/isar-image-base.bb

IMAGE_PREINSTALL += " \
    xen-system-amd64 \
    xen-tools \
    tpm2-tools \
    tpm2-abrmd \
    libtss2-tcti-tabrmd0 \
    tss2 \
    libtss2-esys0 \
    libtss2-dev \
"
