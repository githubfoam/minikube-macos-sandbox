#!/bin/bash
set -o errexit
set -o pipefail
set -o nounset
set -o xtrace
# set -eox pipefail #safety for script

# https://docs.conan.io/en/1.12/getting_started.html
echo "=============================An MD5 Encrypter using the Poco Libraries============================================================"

# an MD5 encrypter app that uses one of the most popular C++ libraries: Poco
# use CMake as build system
# Conan works with any build system and is not limited to using CMake
git clone https://github.com/conan-community/poco-md5-example.git
cd poco-md5-example

# application relies on the Poco libraries
# look for it in the Conan Center remote
conan search Poco* --remote=conan-center

# inspect the metadata of the 1.9.0 version
conan inspect Poco/1.9.0@pocoproject/stable

# using CMake to build the project, 
# which is why the cmake generator is specified.
cat conanfile.txt

# install the required dependencies 
# and generate the information for the build system
conan profile new default --detect  # Generates default profile detecting GCC and sets old ABI
conan profile update settings.compiler.libcxx=libstdc++11 default  # Sets libcxx to C++11 ABI

# Conan installs Poco dependency but also the transitive dependencies for it: OpenSSL and zlib
# generates a conanbuildinfo.cmake file for build system
mkdir build && cd build 
conan install 

# create build file. 
# To inject the Conan information, include the generated conanbuildinfo.cmake file
cat CMakeLists.txt

# build and run Encrypter app
# (win)
# cmake .. -G "Visual Studio 15 Win64"
# cmake --build . --config Release

# build and run Encrypter app
# (linux, mac)
cmake .. -G "Unix Makefiles" -DCMAKE_BUILD_TYPE=Release
cmake --build .
./bin/md5

echo "========================================================================================="
