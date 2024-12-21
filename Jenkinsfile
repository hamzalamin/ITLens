pipeline {
    agent any

    environment {
        DOCKER_IMAGE = 'https://hub.docker.com/repository/docker/hamzalamin/itlens/'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/hamzalamin/ITLens.git'
            }
        }

        stage('Build and Test') {
            steps {
                sh 'chmod +x ./mvnw'
                sh './mvnw clean package'
                sh './mvnw test'
            }
        }

        stage('Code Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    sh './mvnw sonar:sonar'
                }
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker push $DOCKER_IMAGE'
            }
        }

        stage('Deploy') {
            steps {
                sh 'docker-compose up -d'
            }
        }
    }

    post {
        always {
            echo 'Cleaning up ...'
        }
        success {
            echo 'Pipeline succeeded!'
        }
        failure {
            echo 'Pipeline failed!'
        }
    }
}
