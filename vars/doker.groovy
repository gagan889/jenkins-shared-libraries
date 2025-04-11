def call() {
    withCredentials([usernamePassword(credentialsId: 'jenkins-cred', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
    ssh """
            docker login -u ${env.DOCKER_USER} -p ${env.DOCKER_PASS}           
            docker image tag notes-app:latest ${env.DOCKER_USER}/notes-app:latest
            docker push ${env.DOCKER_USER}/notes-app:latest
        """
    }
}
