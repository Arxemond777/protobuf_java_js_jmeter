# curl
## getStates
`curl -X POST -H "Accept: ape: application/json; charset=utf-8' -d '{"parameters":{"requested_timerange":{"start":1673902684217260446,"end":1673902684997350038,"nbTimes":4807}}}' localhost:8080/states`

`curl -s -w 'Establish Connection: %{time_connect}s\nTTFB: %{time_starttransfer}s\nTotal: %{time_total}s\nCurrently uploaded %{size_upload}bytes\n'  -X POST -H "Accept: application/json" -H 'Content-Type: application/json; charset=utf-8' -H 'Cache-Control: no-cache' -d '{"parameters":{"requested_timerange":{"start":1673902684217260446,"end":1673902684997350038,"nbTimes":4807}}}' localhost:8080/states > response.txt`

# generate proto
# protoc and mvn version must be the same
(base) MacBook-Pro-Urij:proto urijglusenkov$ pwd
/Users/urijglusenkov/InteliJ/reserach_paper_optimization/src/main/java/example/proto

(base) MacBook-Pro-Urij:proto urijglusenkov$ protoc --version
libprotoc 3.21.12

(base) MacBook-Pro-Urij:proto urijglusenkov$ protoc --java_out=../.. statesProto.proto

# protocurl
https://github.com/qaware/protocurl/releases -> protocurl_1.5.6_darwin_amd64.zip
unzip
~/Downloads/protocurl_1.5.6_darwin_amd64/bin/protocurl


