from queue import Queue

def produce_packets(q: Queue) -> None:
    """
    Produces packets.
    """
    print('Hello from producer: ' + q.get_nowait())