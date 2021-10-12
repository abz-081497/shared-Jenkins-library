def call(Map stageParams = [:]) {
    withAWS(region: "${AWS_REGION}", credentials:"${AWS_CRED}") {       
        s3Upload( 
            includePathPattern: "**/*",
            bucket: "${stageParams.s3Bucket}"            
        )
    }
}
//awsRegion: "us-east-1", bucket: "testbucket-abigael"
