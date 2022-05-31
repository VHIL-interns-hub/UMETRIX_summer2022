from django.shortcuts import render
from django.views.decorators.csrf import csrf_exempt
from rest_framework.parsers import JSONParser
from django.http.response import JsonResponse

from snippetsApp.models import CodeSnippets, ReferenceTable
from snippetsApp.serializers import CodeSnippetsSerializer, ReferenceTableSerializer
# Create your views here.

@csrf_exempt
def referenceAPI(request, id=0):
    if request.method=='GET':
        references = ReferenceTable.objects.all()
        reference_serializer = ReferenceTableSerializer(references, many=True)
        return JsonResponse(reference_serializer.data, safe = False)
    elif request.method=='POST':
        reference_data=JSONParser().parse(request)
        reference_serializer = ReferenceTableSerializer(data=reference_data)
        if reference_serializer.is_valid():
            reference_serializer.save()
            return JsonResponse("ADDED SUCCESSFULLY", safe=False)
        return JsonResponse("Failed to ADD", safe = False)
    elif request.method=='PUT':
        references_data=JSONParser().parse(request)
        reference = ReferenceTable.objects.get(Tag=references_data['Tag'])
        reference_serializer = ReferenceTableSerializer(reference, data=references_data)
        if reference_serializer.is_valid():
            reference_serializer.save()
            return JsonResponse("SUCCESS", safe=False)
        return JsonResponse("FAIL", safe=False)
    elif request.method=='DELETE':
        reference=ReferenceTable.objects.get(Tag=id)
        reference.delete()
        return JsonResponse("Deleted Successfully",safe=False)
    
# delete method at 16:13 https://www.youtube.com/watch?v=I17uA1sVQ2g&list=PLDA3fgkF3nR0VDXePfev0I1z_de7jeFvG&index=31

