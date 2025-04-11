def call() {
    withCredentials([usernamePassword(credentialsId: 'jenkins-cred', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
    sh 'docker login -u ${env.DOCKER_USER} -p ${env.DOCKER_PASS}'           
    sh 'docker image tag notes-app:latest ${env.DOCKER_USER}/notes-app:latest'
    sh  'docker push ${env.DOCKER_USER}/notes-app:latest'
    }
}
