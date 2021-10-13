def call(Map stageParams = [:]) {
    withAWS(region: "${AWS_REGION}", credentials:"${AWS_CRED}") {       
        s3Upload( 
            bucket: "${stageParams.s3Bucket}",
            includePathPattern: "src/HelloJag.txt",
//             file: "${stageParams.certainFile}"
        )
    }
}
//awsRegion: "us-east-1", s3Bucket: "testbucket-abigael", certainFile: "CertainFileSample.txt"
