def call(String s3Bucket = "testbucket-abigael", Map stageParams = [:]) {
    withAWS(region: "${AWS_REGION}", credentials:"${AWS_CRED}") {
        awsIdentity()
        s3Upload( 
            includePathPattern: "${stageParams.pathFolder}",
            bucket: "${s3Bucket}"
     
                      
        )
    }
}
//awsRegion: "us-east-1", s3Bucket: "testbucket-abigael"
//ito yong path nong para sa pag upload ng folder
// pathFolder: "*.yml, src/HelloAbby.txt"
