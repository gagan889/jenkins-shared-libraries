def call() {
    withCredentials([usernamePassword(credentialsId: 'jenkins-cred', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
    sh """
        echo "${DOCKER_PASS}" | docker login -u "${DOCKER_USER}" --password-stdin
        docker image tag notes-app:latest ${DOCKER_USER}/notes-app:latest
        docker push ${DOCKER_USER}/notes-app:latest
        """
    }
}
