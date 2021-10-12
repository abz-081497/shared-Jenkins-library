def call(Map stageParams = [awsRegion: "us-east-1", s3Bucket: "testbucket-abigael"]) {
    withAWS(region: stageParams.awsRegion, credentials:"${AWS_CRED}") {       
        s3Upload( 
            includePathPattern: "**/*",
            bucket: stageParams.s3Bucket            
        )
    }
}
