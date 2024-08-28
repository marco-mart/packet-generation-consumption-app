from threads import thread_manager
import typing
import threading
from queue import Queue

# Create packet queue
# Create producer and inject packet queue
# Create consumer and inject packet queue

def app_start() -> None:
    """
    Jumping off point for the Packet Generation and Consumption Application
    """
    thread_manager.start_threads()
    return 

if __name__ == '__main__':
    app_start()