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

```
SHELL=bash kas-docker --isar build meta-tb-isar-dev/kas-rootfs.yml
```

* kernel only:

```
SHELL=bash kas-docker --isar build meta-tb-isar-dev/kas-kernel.yml
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
