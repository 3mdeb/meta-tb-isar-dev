require recipes-kernel/linux/linux-custom.inc

SRC_URI += "git:///work/linux-stable/;protocol=file \
    file://apu2_defconfig"

S = "${WORKDIR}/linux-stable"

KERNEL_DEFCONFIG_qemuamd64 = "apu2_defconfig"
