from queue import Queue

def consume_packets(q: Queue) -> None:
    """
    Produces packets.
    """
    print('Hello from consumer: ' + q.get_nowait())
    