require recipes-kernel/linux/linux-custom.inc

KBRANCH = "tb-apu2-dev"

SRC_URI += "git:///work/linux-stable/;protocol=file;branch=${KBRANCH} \
    file://apu2_defconfig"

SRCREV = "${AUTOREV}"
PV = "4.19.36"

S = "${WORKDIR}/linux-stable"

KERNEL_DEFCONFIG_qemuamd64 = "apu2_defconfig"
