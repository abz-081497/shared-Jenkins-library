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
                    uploadTemplateS3()
                }
            }
            stage('Upload File to S3') {                  
                steps {
                    uploadFileS3()
                }
            }
            stage('Deploy EC2') {                  
                steps {
                    deployToEC2()
                }
            }
        }
    }
}
