def call(Map stageParams = [awsRegion: "us-east-1"]){
  withAWS(region: stageParams.awsRegion, credentials:"${AWS_CRED}") {
        awsIdentity()
        cfnCreateChangeSet(
          stack:'EC2Jenkins-Abigael', 
          changeSet:'my-change-set', 
          url:'https://testbucket-abigael.s3.amazonaws.com/deployEC2.yml'
        )
        cfnExecuteChangeSet(
          stack:'EC2Jenkins-Abigael', 
          changeSet:'my-change-set'
        )
  }
}
