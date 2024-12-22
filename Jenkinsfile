pipeline {
    agent any

    environment {
        DOCKER_IMAGE = 'hamzalamin/itlens'
        DOCKER_TAG = 'latest'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/hamzalamin/ITLens.git'
            }
        }

        stage('Build and Test') {
            steps {
                script {
                    docker.image('maven:3.9-eclipse-temurin-22').inside('-v $PWD:/app') {
                        sh 'chmod +x ./mvnw'
                        sh './mvnw clean package -DskipTests'
                    }
                }
            }
        }

        stage('Docker Build') {
            steps {
                script {
                    sh 'docker build -t $DOCKER_IMAGE:$DOCKER_TAG .'
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                script {
                    echo "DEBUG: Starting Push Docker Image stage..."
                }
                withDockerRegistry([credentialsId: '564cabb3-1e39-4375-b2aa-227561939a94', url: '']) {
                    sh 'docker info'
                    sh "docker push ${DOCKER_IMAGE}:${DOCKER_TAG}"
                }
                script {
                    echo "DEBUG: Docker Image pushed successfully!"
                }
            }
        }

        stage('Deploy') {
            steps {
                script {
                    echo 'yeees'
                }
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
