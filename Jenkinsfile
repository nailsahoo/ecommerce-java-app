pipeline {
    agent any

    environment {
        AWS_REGION = 'us-east-1'
        ECR_REPO = '549969919865.dkr.ecr.us-east-1.amazonaws.com/aksproapp'
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/nailsahoo/ecommerce-java-app.git'
            }
        }

        stage('Build') {
            steps {
                sh 'cd backend && mvn clean package'
            }
        }

        stage('Upload to Nexus') {
    steps {
        nexusArtifactUploader(
            nexusVersion: 'nexus3',
            protocol: 'http',
            nexusUrl: '54.90.207.176:8081',
            groupId: 'com.ecommerce',
            version: '1.0',
            repository: 'maven-releases',
            credentialsId: 'nexus-creds',
            artifacts: [
                [artifactId: 'ecommerce-app',
                 classifier: '',
                 file: 'target/ecommerce-app-1.0.jar',
                 type: 'jar']
            ]
        )
    }
}
        stage('Docker Build') {
            steps {
                sh 'docker build -t aksproapp .'
            }
        }

        stage('Tag Image') {
            steps {
                sh 'docker tag aksproapp:latest $ECR_REPO:latest'
            }
        }

        stage('Login to ECR') {
            steps {
               sh '''
                 aws ecr get-login-password --region us-east-1 | \
                 docker login --username AWS --password-stdin 549969919865.dkr.ecr.us-east-1.amazonaws.com
               '''
            }
        }

        stage('Push to ECR') {
            steps {
                sh 'docker push $ECR_REPO:latest'
            }
        }
    }
}
