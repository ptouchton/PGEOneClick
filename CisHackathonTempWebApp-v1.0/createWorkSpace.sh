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
export BUILD_DIR=.

# Set the locations for the IBM deploy batch scripts
export SERVICEDEPLOY=$STUDIO_DIR/runtimes/bi_v7/bin/serviceDeploy.sh
export EJBDEPLOY=$STUDIO_DIR/runtimes/bi_v7/bin/ejbdeploy.sh
export WSDEPLOY=$STUDIO_DIR/runtimes/bi_v7/bin/wsdeploy.sh
$ANT_HOME/bin/ant -Dbuild.config=buildConfig.properties createWorkSpace
