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

## Build

```
SHELL=bash kas-docker --isar build meta-tb-isar-dev/kas.yml
```

## Development

### Rootfs modification

Simply add the `Debian` packages you need to the `isar-image-xen.bb` recipe.

### Linux kernel modification
