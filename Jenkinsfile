pipeline {
    agent any
    
    stages {
        
        stage ("Git Checkout") {
            steps {
                
                script {
                   git 'https://github.com/purna16/demo2.git' 
                    
                }
            }
        }
        stage ("Unit Test"){
            
            steps {
                    
                script {
                        
                    sh "mvn test"
                }
                
            }
            
        }
        stage ("Maven Build") {
            
            steps {
                
                script {
                    
                    sh "mvn clean package"
                }
            }
        }
        stage ("Creating Docker Image") {
            
            steps {
                
                script {
                   sh 'docker image build -t $JOB_NAME:v1.$BUILD_ID .'
                   sh 'docker image tag $JOB_NAME:v1.$BUILD_ID purna16/$JOB_NAME:v1.$BUILD_ID'
                   sh 'docker image tag $JOB_NAME:v1.$BUILD_ID purna16/$JOB_NAME:latest'
                }
            }
        }
        stage ("Pushing Image To Docker Hub") {
            
            steps {
                
                script{
                    withCredentials([string(credentialsId: 'dockerhub_passwd', variable: 'docker_password')]) {
                        sh 'docker login -u purna16 -p ${docker_password}'
                        sh 'docker image push purna16/$JOB_NAME:v1.$BUILD_ID'
                        sh 'docker image push purna16/$JOB_NAME:latest'
                    }
                }
            }
        }
        stage ("Completed") {
            
            steps {
                
                script {
                    
                    echo 'completed maven test & build, created docker image and pushed to docker hub'
                }
            }
        }
        
    }
}
