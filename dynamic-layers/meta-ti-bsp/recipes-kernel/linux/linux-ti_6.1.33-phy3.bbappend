COMPATIBLE_MACHINE:phyboard-electra-am64xx-2 = "phyboard-electra-am64xx-2"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += " file://holidaydisplay.patch \
	     file://fragment.cfg \
	   "
