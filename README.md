# meta-tb-isar-dev

## Prepare

* get `kas-docker` script:

```
wget -O ~/bin/kas-docker https://raw.githubusercontent.com/siemens/kas/1.0/kas-docker
```

* clone our repo:

```
mkdir tb-sdk
cd tb-sdk
git clone git@github.com:3mdeb/meta-tb-isar-dev.git
```

* clone linux repo:

> It will be convenient for local linux development. It is required by the
> `linux-apu2-local_git.bb` recipe

```
git clone --branch tb-apu2-dev git@github.com:3mdeb/linux-stable.git
```

## Build

* whole image:

> Below command will build kernel and rootfs. Kernel modules are part of the
> rootfs.

```
SHELL=bash kas-docker --isar build meta-tb-isar-dev/kas-rootfs.yml
```

## Development

### Rootfs modification

Simply add the `Debian` packages you need to the `isar-image-xen.bb` recipe.

### Linux kernel modification

#### configuration

Simply edit the `recipes-kernel/linux/files/apu2_defconfig`. The best practice
would be to:
* enable / disable options via `menuconfig`
* save config with `make savedefconfig`
* copy `defconfig` into `apu2_defconfig`

#### source modification

* Make some changes in the `tb-sdk/linux-stable` repo and commit them
* rebuild

## Deploy

Build artifacts are available in `isar-sdk/build/tmp/deploy/images/qemuamd64`:

```
-rw-r--r-- 1 root    root     72M Apr 25 13:26 isar-image-xen-debian-buster-qemuamd64.tar.gz
-rw-r--r-- 1 root    root    5.1M Apr 25 13:26 isar-image-xen-debian-buster-qemuamd64.initrd.img-4.19.36
-rw-r--r-- 1 builder builder 8.0M Apr 25 13:26 isar-image-xen-debian-buster-qemuamd64.vmlinuz-4.19.36
```
