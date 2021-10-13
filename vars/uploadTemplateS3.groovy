def call(Map stageParams = [awsRegion: "us-east-1", s3Bucket: "testbucket-abigael"]) {
    withAWS(region: stageParams.awsRegion, credentials:"${AWS_CRED}") {
        awsIdentity()
        s3Upload( 
            includePathPattern: "${stageParams.pathFolder}",
            bucket: "${stageParams.s3Bucket}"
                      
        )
    }
}
//ito yong path nong para sa pag upload ng folder
// pathFolder: "*.yml, src/HelloAbby.txt"
