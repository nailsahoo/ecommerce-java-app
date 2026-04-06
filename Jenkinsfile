pipeline {
    agent any

    tools {
        maven 'Maven'  // configure in Jenkins
    }

    environment {
        NEXUS_URL = 'http://54.90.203.107:8081'
        NEXUS_REPO = 'maven-releases'
    }

    stages {

        stage('Checkout Code') {
            steps {
                git 'https://github.com/nailsahoo/ecommerce-java-app.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('sonar-server') {
                    sh 'mvn sonar:sonar'
                }
            }
        }

        stage('Upload to Nexus') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: 'nexus-creds',
                    usernameVariable: 'USERNAME',
                    passwordVariable: 'PASSWORD'
                )]) {
                    sh '''
                    mvn deploy -Dnexus.username=$USERNAME -Dnexus.password=$PASSWORD
                    '''
                }
            }
        }
    }
}
