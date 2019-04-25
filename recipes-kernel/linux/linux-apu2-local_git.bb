require recipes-kernel/linux/linux-custom.inc

KBRANCH = "tb-apu2-dev"

SRC_URI += "git:///work/linux-stable/;protocol=file;branch=${KBRANCH};destsuffix=${P} \
    file://apu2_defconfig"

# always build from latest available commit in the local repo
AUTOREV = "${@bb.fetch2.get_autorev(d)}"
SRCREV = "${AUTOREV}"

# remove '+' sign from output of the "make -s kernelrelease"
export LOCALVERSION = ""

PV = "4.19.36"

S = "${WORKDIR}/${PN}-${PV}"

KERNEL_DEFCONFIG_qemuamd64 = "apu2_defconfig"
