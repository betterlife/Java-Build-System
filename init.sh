cp -R projectTemplate/* ../
mv ../project.iml.sample ../project.iml
mv ../project.ipr.sample ../project.ipr
mv ../project.iws.sample ../project.iws
cd ..
ln -s .builder/build.xml build.xml
