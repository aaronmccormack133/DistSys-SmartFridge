import grpc
import contents_pb2 
import contents_pb2_grpc 

class addFoodClient(object):
    def __init__(self):
        self.host = 'localhost'
        self.server_port = 8080

        self.channel = grpc.insecure_channel('{}:{}'.format(self.host, self.server_port))

        self.stub = contents_pb2_grpc.ContentsStub(self.channel)

    def get_food(self, message):
        added_name = contents_pb2.Food(name=message)
        print(added_name)
        return self.stub.AddFood(added_name)
        # AddFood is shown in the stub but it's not finding it here 
        # I can't resolve this issue

curr_client = addFoodClient()
curr_client.get_food("apple")