def call() {
    pipeline {
        agent any
        environment {
            AWS_CRED = 'cloud_user'
            AWS_REGION = 'us-east-1'
        }
        stages {
            stage('Upload template to S3') {                  
                steps {
                    uploadTemplateS3(s3Bucket:"testbucket-abigael")
                }
            }
            stage('Upload Certain File to S3') {                  
                steps {
                    uploadCertainFileS3(s3Bucket:"testbucket-abigael", certainFile: "CertainFileSample.txt")
                    uploadCertainFileS3(s3Bucket:"testbucket-abigael", certainFile: "HelloWorld.txt")
                }
            }
//             stage('Delete HelloWorld.txt from S3 bucket') {                  
//                 steps {
//                     deleteFileS3(s3Bucket: "testbucket-abigael", pathName: "HelloWorld.txt")
//                 }
//             }
            stage('Deploy EC2') {                  
                steps {
                    deployToEC2()
                }
            }
        }
    }
}
