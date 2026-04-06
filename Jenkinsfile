pipeline {
    agent any

    tools {
        maven 'Maven3'
    }

    stages {

        stage('Git Checkout') {
            steps {
                git 'https://github.com/nailsahoo/ecommerce-java-app.git'
            }
        }

        stage('Build') {
            steps {
                #commet
                sh 'mvn clean package'
            }
        }

    }
}
