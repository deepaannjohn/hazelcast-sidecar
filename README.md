kubectl apply -f https://raw.githubusercontent.com/hazelcast/hazelcast/master/kubernetes-rbac.yaml

This command:

Creates a Role with permissions to list services and pods in the namespace.
Creates a RoleBinding to associate the Role with the default service account.
