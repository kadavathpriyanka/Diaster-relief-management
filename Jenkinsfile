pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                echo 'Source code checked out from GitHub'
            }
        }

        stage('Build Backend') {
            steps {
                dir('backend') {
                    bat 'mvn clean package -DskipTests'
                }
            }
        }

        stage('Test Backend') {
            steps {
                dir('backend') {
                    bat 'mvn test'
                }
            }
        }

        stage('Docker Build') {
            steps {
                bat 'docker compose build'
            }
        }

        stage('Docker Deploy') {
            steps {
                bat 'docker compose up -d'
            }
        }
    }

    post {
        success {
            echo 'Disaster Relief application deployed successfully!'
        }

        failure {
            echo 'Pipeline failed. Check the console output.'
        }
    }
}
