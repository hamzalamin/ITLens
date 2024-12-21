pipeline {
    agent any

    environment {
        DOCKER_IMAGE = 'https://hub.docker.com/repository/docker/hamzalamin/itlens/'
    }

    stages {
        stage('checkout') {
            steps {
                git 'https://github.com/hamzalamin/ITLens'
            }
            steps {
                sh './maven clean package'
            }
            steps {
                sh './maven test'
            }
        }
        stage('Code Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    sh './maven sonar:sonar'
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