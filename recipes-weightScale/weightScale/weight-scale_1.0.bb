# Copyright (C) 2023 tloan <tloan@phytec.com>
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "phyFood Drive - weight-scale Service Recipe"
LICENSE = "CLOSED"

RDEPENDS:${PN} += "bash"

inherit systemd

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE:${PN} = "weight-scale.service"

SRC_URI = " \
    file://displayWeight.sh \
    file://readWeight.sh \
    file://readWeight_dummy.sh \
    file://weight-scale.service \
"

FILES:${PN} += " \
    ${systemd_unitdir}/system/weight-scale.service \
    ${bindir}/displayWeight.sh \
    ${bindir}/readWeight.sh \
    ${bindir}/readWeight_dummy.sh \
"


do_install:append() {
  install -d ${D}/${systemd_unitdir}/system
  install -m 0644 ${WORKDIR}/weight-scale.service ${D}/${systemd_unitdir}/system/weight-scale.service

  install -d ${D}/${bindir}
  install -m 0755 ${WORKDIR}/displayWeight.sh ${D}/${bindir}/displayWeight.sh
  install -m 0755 ${WORKDIR}/readWeight.sh ${D}/${bindir}/readWeight.sh
  install -m 0755 ${WORKDIR}/readWeight_dummy.sh ${D}/${bindir}/readWeight_dummy.sh
}

COMPATIBLE_MACHINE:phyboard-electra-am64xx-2 = "phyboard-electra-am64xx-2"
