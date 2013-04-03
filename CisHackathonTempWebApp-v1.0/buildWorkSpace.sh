#!/bin/bash

# ANT Home Dir
export ANT_HOME=/opt/apache-ant-1.7.1
               
# Set JAVA_HOME to JDK path
export JAVA_HOME=/IBM/WID7_WTE/runtimes/bi_v7/java

# Set the location for the IBM installation
export STUDIO_DIR=/IBM/WID7_WTE

# Set the the location of the Runtim dir
export WID_LIB_DIR=/IBM/WID7_WTE/runtimes/bi_v7/lib/ext

# Set the location of the build dir
export BUILD_DIR=/tmp/sandbox/BuildScriptbuild

# Set the locations for the IBM deploy batch scripts
export SERVICEDEPLOY=/IBM/WID7_WTE/runtimes/bi_v7/profiles/qwps/bin/serviceDeploy.sh

export EJBDEPLOY=/IBM/WID7_WTE/runtimes/bi_v7/profiles/qwps/bin/ejbdeploy.sh
export WSDEPLOY=/IBM/WID7_WTE/runtimes/bi_v7/profiles/qwps/bin/wsdeploy.sh
$ANT_HOME/bin/ant -Dbuild.config=buildConfig.properties createWorkSpace buildWorkSpace
