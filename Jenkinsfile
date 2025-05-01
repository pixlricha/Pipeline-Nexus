pipeline {
    agent any

    environment {
        DOCKER_IMAGE = 'your-dockerhub-username/todo-app:latest'
    }

    stages {
        stage('Clone') {
            steps {
                git 'https://github.com/yourusername/todo-app.git'
            }
        }

        stage('Build with Maven') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Unit Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Code Analysis') {
            steps {
                sh 'mvn sonar:sonar -Dsonar.projectKey=todo -Dsonar.host.url=http://localhost:9000 -Dsonar.login=YOUR_TOKEN'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t $DOCKER_IMAGE .'
            }
        }

        stage('Trivy Scan') {
            steps {
                sh 'trivy image $DOCKER_IMAGE'
            }
        }

        stage('Push to DockerHub') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerhub-creds', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
                    sh 'echo $PASS | docker login -u $USER --password-stdin'
                    sh 'docker push $DOCKER_IMAGE'
                }
            }
        }

        stage('Deploy to ECS') {
            steps {
                echo 'Trigger ECS Deployment (configure with AWS CLI or Terraform separately)'
            }
        }
    }
}
